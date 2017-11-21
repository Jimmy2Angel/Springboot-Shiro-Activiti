package indi.baojie.supervision.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Lollipop on 2017/6/16.
 */
@Configuration
@ImportResource("classpath:spring/spring-activiti.xml")
public class ActivitiConfig {
//    //流程配置，与spring整合采用SpringProcessEngineConfiguration这个实现
//    @Bean
//    public ProcessEngineConfiguration processEngineConfiguration(DataSource dataSource, PlatformTransactionManager transactionManager){
//        SpringProcessEngineConfiguration processEngineConfiguration = new SpringProcessEngineConfiguration();
//        processEngineConfiguration.setDataSource(dataSource);
//        processEngineConfiguration.setDatabaseSchemaUpdate("true");
//        processEngineConfiguration.setDatabaseType("mysql");
//        processEngineConfiguration.setTransactionManager(transactionManager);
//        return processEngineConfiguration;
//    }
//
//    //流程引擎，与spring整合使用factoryBean
//    @Bean
//    public ProcessEngineFactoryBean processEngine(ProcessEngineConfiguration processEngineConfiguration){
//        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
//        processEngineFactoryBean.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);
//        return processEngineFactoryBean;
//    }
//
//    //八大接口
//    @Bean
//    public RepositoryService repositoryService(ProcessEngine processEngine){
//        return processEngine.getRepositoryService();
//    }
//
//    @Bean
//    public RuntimeService runtimeService(ProcessEngine processEngine){
//        return processEngine.getRuntimeService();
//    }
//
//    @Bean
//    public TaskService taskService(ProcessEngine processEngine){
//        return processEngine.getTaskService();
//    }
//
//    @Bean
//    public HistoryService historyService(ProcessEngine processEngine){
//        return processEngine.getHistoryService();
//    }
//
//    @Bean
//    public FormService formService(ProcessEngine processEngine){
//        return processEngine.getFormService();
//    }
//
//    @Bean
//    public IdentityService identityService(ProcessEngine processEngine){
//        return processEngine.getIdentityService();
//    }
//
//    @Bean
//    public ManagementService managementService(ProcessEngine processEngine){
//        return processEngine.getManagementService();
//    }
//
//    @Bean
//    public DynamicBpmnService dynamicBpmnService(ProcessEngine processEngine){
//        return processEngine.getDynamicBpmnService();
//    }
//
//    //八大接口 end
}
