package IM;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ClassName WebSocketConfig
 * @Description
 * @Author Administrator
 * @Date 2020/7/22 0022 17:52
 */
@Configuration
public class WebSocketConfig {
    /**
     * 创建 ServerEndpointExporter 组件，交由 spring IOC 容器管理，
     * 它会自动扫描注册应用中所有的 @ServerEndpoint
     *
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
