# README

1. Generate a docker image with the graalvm compiler
    ```
    ./create_build_image
    ```  
1. Generate runtime info in src/main/resources/META-INF/native-image

    1. run:
    
        ```
        ./generate_runtime_info
        ```
    1. point your browser to http://localhost:8080/
    1. ctrl-c
1. Generate an executable
    ```$xslt
    ./build
    ```
1. Get coffee
1. Inspect the executable
    ```
    ldd ./target/test1
        linux-vdso.so.1 (0x00007ffcc7fdc000)
        libstdc++.so.6 => /lib/x86_64-linux-gnu/libstdc++.so.6 (0x00007f9d881da000)
        libpthread.so.0 => /lib/x86_64-linux-gnu/libpthread.so.0 (0x00007f9d881b9000)
        libdl.so.2 => /lib/x86_64-linux-gnu/libdl.so.2 (0x00007f9d881b4000)
        libz.so.1 => /lib/x86_64-linux-gnu/libz.so.1 (0x00007f9d87f96000)
        librt.so.1 => /lib/x86_64-linux-gnu/librt.so.1 (0x00007f9d87f8c000)
        libc.so.6 => /lib/x86_64-linux-gnu/libc.so.6 (0x00007f9d87dcb000)
        libm.so.6 => /lib/x86_64-linux-gnu/libm.so.6 (0x00007f9d87c46000)
        /lib64/ld-linux-x86-64.so.2 (0x00007f9d8837a000)
        libgcc_s.so.1 => /lib/x86_64-linux-gnu/libgcc_s.so.1 (0x00007f9d87c2c000)
    ```
   
   nice!
   
1. Run the image
    ```
    ./target/test1
      .   ____          _            __ _ _
     /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
     \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
      '  |____| .__|_| |_|_| |_\__, | / / / /
     =========|_|==============|___/=/_/_/_/
     :: Spring Boot ::                        

    2020-06-14 22:51:20.974  INFO 7109 --- [           main] n.a.graalvm.test1.Test1Application       : Starting Test1Application on elza with PID 7109 (/home/bhuism/workspace/test1/target/test1 started by bhuism in /home/bhuism/workspace/test1)
    2020-06-14 22:51:20.974  INFO 7109 --- [           main] n.a.graalvm.test1.Test1Application       : No active profile set, falling back to default profiles: default
    2020-06-14 22:51:21.005  INFO 7109 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
    2020-06-14 22:51:21.005  INFO 7109 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
    2020-06-14 22:51:21.005  INFO 7109 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.35]
    2020-06-14 22:51:21.006  INFO 7109 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
    2020-06-14 22:51:21.006  INFO 7109 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 32 ms
    2020-06-14 22:51:21.014  INFO 7109 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
    2020-06-14 22:51:21.023  INFO 7109 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    2020-06-14 22:51:21.024  INFO 7109 --- [           main] n.a.graalvm.test1.Test1Application       : Started Test1Application in 0.056 seconds (JVM running for 0.059)
    2020-06-14 22:51:28.490  INFO 7109 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
    2020-06-14 22:51:28.490  INFO 7109 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
    2020-06-14 22:51:28.492  INFO 7109 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
    2020-06-14 22:55:31.308  INFO 7109 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
    ```
    point your browser to http://localhost:8080/