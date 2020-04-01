package com.hou.web.web04;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;

//TomcatConnectorCustomizer接口:定制tomcat连接
public class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer {
    public void customize(Connector connector) {
        //转换为默认的连接器
        Http11NioProtocol protocl = (Http11NioProtocol) connector.getProtocolHandler();
        //设置最大连接数
        protocl.setMaxConnections(2000);
        //设置最大线程数
        protocl.setMaxThreads(500);
    }
}