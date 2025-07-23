package cn.jing.gateway.session;

/**
 * 会话工厂接口 - 定义会话创建的标准：
 * - `openSession` ：创建新的会话实例
 * - 采用工厂模式，解耦会话创建与具体实现
 */
public interface GatewaySessionFactory {

    GatewaySession openSession();

}