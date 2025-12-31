package condefinance.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerConfig {
    private static final int SERVER_PORT = 8080;

    private HttpServerConfig() {}

    public static void start() {
        try {
            HttpServer server = HttpServer.create(
                    new InetSocketAddress(SERVER_PORT), 0
            );

            server.createContext("/home", exchange -> {
                String response = "OK";
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
            });

            server.start();
            System.out.println("🚀 Servidor iniciado na porta " + SERVER_PORT);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
