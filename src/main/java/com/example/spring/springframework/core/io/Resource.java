package com.example.spring.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源接口
 */
public interface Resource {
    /**
     * 获取资源接口的一个io流
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
