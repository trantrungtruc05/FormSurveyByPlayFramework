package modules.registry;

import java.util.concurrent.ScheduledExecutorService;

import akka.actor.ActorSystem;
import api.ApiDispatcher;
import dao.jdbc.JdbcSurveyDAO;
import play.Application;
import play.Configuration;
import play.i18n.Lang;
import play.i18n.MessagesApi;
import play.libs.ws.WSClient;

/**
 * Application's central registry interface.
 * 
 * @author Thanh Nguyen <btnguyen2k@gmail.com>
 * @since template-v0.1.0
 */
public interface IRegistry {

    /**
     * Get the current running Play application.
     *
     * @return
     */
    public Application getPlayApplication();

    /**
     * Get the current Play application's configuration.
     * 
     * @return
     */
    public Configuration getAppConfiguration();

    /**
     * Get application's available languages defined in
     * {@code application.conf}.
     * 
     * @return
     */
    public Lang[] getAvailableLanguage();

    /**
     * Get the {@link ActorSystem} instance.
     *
     * @return
     */
    public ActorSystem getActorSystem();

    /**
     * Get the {@link MessagesApi} instance.
     * 
     * @return
     */
    public MessagesApi getMessagesApi();

    /**
     * Get the {@link WSClient} instance.
     * 
     * @return
     */
    public WSClient getWsClient();

    /**
     * Get the global {@link ScheduledExecutorService} instance.
     * 
     * @return
     * @since template-v0.1.2.1
     */
    public ScheduledExecutorService getScheduledExecutorService();

    /**
     * Get a Spring bean by clazz.
     */
    public <T> T getBean(Class<T> clazz);

    /**
     * Get a Spring bean by name and clazz.
     */
    public <T> T getBean(String name, Class<T> clazz);

    /**
     * Get {@link ApiDispatcher} instance.
     * 
     * @return
     * @since template-v0.1.4
     */
    public ApiDispatcher getApiDispatcher();
    
    public JdbcSurveyDAO getJdbcSurvey();
}
