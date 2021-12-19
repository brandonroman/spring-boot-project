package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.CubeResult;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
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
public class FundamentosApplication implements CommandLineRunner {
	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private CubeResult cubeResult;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, CubeResult cubeResult, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.cubeResult = cubeResult;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser() {
//		LOGGER.info("Usuario con el método findByUserMEail" + userRepository.findByUserEmail("john@gmail.com").orElseThrow(() -> new RuntimeException("No se encontró el usuario")));
//		userRepository.findAndSort("user", Sort.by("id").descending()).stream().forEach(user -> LOGGER.info("Usuario con método sort " + user));
//		userRepository.findByName("John").stream().forEach(user -> LOGGER.info("Usuario con query method" + user));
//		userRepository.findByEmailAndName("daniela@gmail.com", "Daniela").stream().forEach(user -> LOGGER.info("Usuario con query method" + user));
//		userRepository.findByNameLike("%user%")
//				.stream()
//				.forEach(
//						user -> LOGGER.info("Usuario findByNameLike " + user)
//				);
//		userRepository.findByNameOrEmail("user10", null)
//				.stream()
//				.forEach(
//						user -> LOGGER.info("Usuario findByNameOrEmail " + user)
//				);
	}

	private void saveUsersInDataBase() {
		User user1 = new User("John", "john@gmail.com", LocalDate.of(2021, 03, 20));
		User user2 = new User("Julie", "julie@gmail.com", LocalDate.of(2021, 05, 20));
		User user3 = new User("Daniela", "daniela@gmail.com", LocalDate.of(2021, 03, 20));
		User user4 = new User("user4", "user4@gmail.com", LocalDate.of(2021, 10, 20));
		User user5 = new User("user5", "user5@gmail.com", LocalDate.of(2021, 01, 20));
		User user6 = new User("user6", "user6@gmail.com", LocalDate.of(2021, 01, 20));
		User user7 = new User("user7", "user7@gmail.com", LocalDate.of(2021, 06, 20));
		User user8 = new User("user8", "user8@gmail.com", LocalDate.of(2021, 02, 20));
		User user9 = new User("user9", "user9@gmail.com", LocalDate.of(2021, 12, 20));
		User user10 = new User("user10", "user10@gmail.com", LocalDate.of(2021, 11, 20));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
		list.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores() {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		cubeResult.printCubeResult();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());
		try {
			//error
			int value = 10/0;
			LOGGER.debug("Mi valor: " + value);
		} catch (Exception e) {
			LOGGER.error(
					"Esto es un error al dividir por cero " + e.getStackTrace()
			);
		}
	}
}
