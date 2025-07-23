package cn.jing.gateway.session.defaults;

import cn.jing.gateway.session.Configuration;
import cn.jing.gateway.session.GatewaySession;
import cn.jing.gateway.session.GatewaySessionFactory;


public class DefaultGatewaySessionFactory implements GatewaySessionFactory {

    private final Configuration configuration;

    public DefaultGatewaySessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public GatewaySession openSession() {
        return new DefaultGatewaySession(configuration);
    }

}
