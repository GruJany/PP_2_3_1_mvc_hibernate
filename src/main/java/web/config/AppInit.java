package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод, указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }


    /* Данный метод указывает url, на котором будет базироваться приложение */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    //   @Override
    // public void onStartup(ServletContext aServletContext) throws ServletException {
    //     super.onStartup(aServletContext);
    //     registerHiddenFieldFilter(aServletContext);


    //     CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    //     characterEncodingFilter.setEncoding("UTF-8");
    //     characterEncodingFilter.setForceEncoding(true);

    //     FilterRegistration.Dynamic filterRegistration = aServletContext
    //             .addFilter("characterEncodingFilter", characterEncodingFilter);
    //     filterRegistration.addMappingForUrlPatterns(null, false, "/*");
    // }

    // private void registerHiddenFieldFilter(ServletContext aContext) {
    //     aContext.addFilter("hiddenHttpMethodFilter",
    //             new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
    // }

}
