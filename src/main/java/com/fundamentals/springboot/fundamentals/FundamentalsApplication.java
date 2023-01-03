package com.fundamentals.springboot.fundamentals;

import com.fundamentals.springboot.fundamentals.bean.BeanWithProperties;
import com.fundamentals.springboot.fundamentals.bean.MyBean;
import com.fundamentals.springboot.fundamentals.bean.MyBeanWithDependency;
import com.fundamentals.springboot.fundamentals.component.ComponentDependency;
import com.fundamentals.springboot.fundamentals.entity.User;
import com.fundamentals.springboot.fundamentals.pojo.UserPojo;
import com.fundamentals.springboot.fundamentals.repository.UserRepository;
import com.fundamentals.springboot.fundamentals.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentalsApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentalsApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private BeanWithProperties beanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	public FundamentalsApplication(@Qualifier("componentImplement") ComponentDependency componentDependency,
								   MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								   BeanWithProperties beanWithProperties, UserPojo userPojo, UserRepository userRepository,
								   UserService userService) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.beanWithProperties = beanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentalsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//examples();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
		saveWithTransactional();
	}

	private void saveWithTransactional(){
		User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
		User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
		User test3 = new User("TestTransactional3", "TestTransactional1@domain.com", LocalDate.now());
		User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());

		List<User> users = Arrays.asList(test1,test2,test3,test4);

		try{
			userService.saveTransactional(users);
		}catch (Exception e){
			LOGGER.error("Esta es una exception dentro del metodo transaccional " + e);
		}

		userService.getAllUsers().forEach(user -> LOGGER.info("Este es el usuario dentro del metodo transanccional ->" + user));
	}

	private void getInformationJpqlFromUser(){
		LOGGER.info("Usuario con el metodo findbyuseremail: " + userRepository.findByUserEmail("julie@domain.com")
				.orElseThrow(() -> new RuntimeException("No se encontro el usaurio")));

		userRepository.findAndSort("Ju", Sort.by("id").descending())
				.forEach(user -> LOGGER.info("Usuario con metodo sort: "+user));

		userRepository.findByName("Jhon").forEach(user -> LOGGER.info("usuario con querymethod: "+user));

		LOGGER.info("usuario con querymethod name and email:" + userRepository.findByEmailAndName("vicente@domain.com", "Vicente")
				.orElseThrow(()-> new RuntimeException("Usuario no encontrado")));

		userRepository.findByNameLike("%M%").forEach(user -> LOGGER.info("usuario findByname LIke "+user));

		userRepository.findByNameOrEmail(null, "pedro@domain.com").forEach(user -> LOGGER.info("usuario findbynameoremail "+user));

		userRepository.findByBirthDateBetween(LocalDate.of(2022,1,1), LocalDate.of(2022,5,30))
				.forEach(user -> LOGGER.info("usuario por birthdate: "+user));

		userRepository.findByNameLikeOrderByIdDesc("%M%").forEach(user -> LOGGER.info("usuario encontrado con like y ordenado "+user));

		userRepository.findByNameContainingOrderByIdAsc("M").forEach(user -> LOGGER.info("usuario encontrado con containing y ordenado "+user));

		LOGGER.info("El usuario a partir del named parameter es: " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2022,5,3), "julie@domain.com")
				.orElseThrow(()->new RuntimeException("No se encontro el usuario a partir del named parameter")));
	}


	private void saveUsersInDataBase(){
		User user1 = new User("Jhon","john@domain.com", LocalDate.of(2022,12,20));
		User user2 = new User("Julie","julie@domain.com", LocalDate.of(2022,5,3));
		User user3 = new User("Pedro","pedro@domain.com", LocalDate.of(2022,4,2));
		User user4 = new User("Juan","juan@domain.com", LocalDate.of(2022,3,21));
		User user5 = new User("Vicente","vicente@domain.com", LocalDate.of(2022,11,5));
		User user6 = new User("Carlos","carlos@domain.com", LocalDate.of(2022,10,3));
		User user7 = new User("Mikel","mikel@domain.com", LocalDate.of(2022,12,30));
		User user8 = new User("Rolando","rolando@domain.com", LocalDate.of(2022,1,1));
		User user9 = new User("Marco","marco@domain.com", LocalDate.of(2022,2,7));
		User user10 = new User("Christian","christian@domain.com", LocalDate.of(2022,5,23));
		User user11 = new User("Sergio","sergio@domain.com", LocalDate.of(2022,6,20));
		User user12 = new User("David","david@domain.com", LocalDate.of(2022,7,15));
		List<User> userList = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11,user12);

		userList.stream().forEach(userRepository::save);

	}



	private void examples() {
		componentDependency.sayHi();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(beanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());
		try {
			int var = 10 / 0;
			LOGGER.debug("Mi valor es: " + var);
		} catch (Exception e) {
			LOGGER.error("Error del app " + e.getMessage());
		}
	}
}