package com.checkthelogs.musicservice;

import ratpack.server.RatpackServer;

public class MusicService {
    public static void main(String[] args) throws Exception {

        RatpackServer.start(ratpackServerSpec -> ratpackServerSpec

                .serverConfig(serverConfigBuilder -> serverConfigBuilder
                        .port(8080)
                        .build())

                .handlers(chain -> chain

                        //Status endpoint that just returns OK (used by the docker plugin to check that the service is up)
                        .get("status", ctx -> ctx.getResponse().send("OK"))

                        //Simple endpoint that we will test in our functional tests
                        .get("sayHello", ctx -> ctx.getResponse().send("Hello from music-service"))
                )
        );
    }
}
