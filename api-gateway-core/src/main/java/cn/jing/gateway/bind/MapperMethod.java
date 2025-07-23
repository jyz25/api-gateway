package cn.jing.gateway.bind;


import cn.jing.gateway.mapping.HttpCommandType;
import cn.jing.gateway.session.Configuration;
import cn.jing.gateway.session.GatewaySession;

import java.lang.reflect.Method;

/**
 * 封装具体的方法调用逻辑，负责参数解析、服务调用和结果处理。
 */
public class MapperMethod {

    private String uri;
    private final HttpCommandType command;

    public MapperMethod(String uri, Method method, Configuration configuration) {
        this.uri = uri;
        this.command = configuration.getHttpStatement(uri).getHttpCommandType();
    }

    public Object execute(GatewaySession session, Object args) {
        Object result = null;
        switch (command) {
            case GET:
                result = session.get(uri, args);
                break;
            case POST:
                break;
            case PUT:
                break;
            case DELETE:
                break;
            default:
                throw new RuntimeException("Unknown execution method for: " + command);
        }
        return result;
    }

}
