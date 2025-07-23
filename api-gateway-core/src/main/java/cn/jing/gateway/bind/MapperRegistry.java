package cn.jing.gateway.bind;


import cn.jing.gateway.mapping.HttpStatement;
import cn.jing.gateway.session.Configuration;
import cn.jing.gateway.session.GatewaySession;

import java.util.HashMap;
import java.util.Map;

/**
 * - 作用 ：管理 URI 与后端服务的映射关系，相当于“路由注册表”。
 * - 核心能力 ：
 * - 通过 addMapper(HttpStatement) 注册路由规则
 * - 通过 getMapper(uri, session) 获取映射器实例
 */
public class MapperRegistry {

    private final Configuration configuration;

    public MapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }

    // 泛化调用静态代理工厂
    private final Map<String, MapperProxyFactory> knownMappers = new HashMap<>();

    public IGenericReference getMapper(String uri, GatewaySession gatewaySession) {
        final MapperProxyFactory mapperProxyFactory = knownMappers.get(uri);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Uri " + uri + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(gatewaySession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public void addMapper(HttpStatement httpStatement) {
        String uri = httpStatement.getUri();
        // 如果重复注册则报错
        if (hasMapper(uri)) {
            throw new RuntimeException("Uri " + uri + " is already known to the MapperRegistry.");
        }
        knownMappers.put(uri, new MapperProxyFactory(uri));
        // 保存接口映射信息
        configuration.addHttpStatement(httpStatement);
    }

    public <T> boolean hasMapper(String uri) {
        return knownMappers.containsKey(uri);
    }

}
