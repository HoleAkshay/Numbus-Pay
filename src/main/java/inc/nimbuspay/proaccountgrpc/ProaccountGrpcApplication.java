package inc.nimbuspay.proaccountgrpc;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import inc.nimbuspay.proaccountgrpc.controller.AcquirerToIssuerCardTransactionsServiceController;
import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class ProaccountGrpcApplication {

	/**
	 * Creates and configures a gRPC server instance.
	 * 
	 * @return The configured gRPC server.
	 */
	@Bean
	public Server grpcServer(AcquirerToIssuerCardTransactionsServiceController service) {
		return ServerBuilder.forPort(9090)
				.addService(service)
				.build();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		ConfigurableApplicationContext context = SpringApplication.run(ProaccountGrpcApplication.class, args);
		Server server = context.getBean(Server.class);
		server.start();
		server.awaitTermination();
	}

	// @Bean
	// public Server grpcServer(AcquirerToIssuerCardTransactionsServiceController service) {
	// 	return ServerBuilder.forPort(9090)
	// 			.addService(service)
	// 			.build();
	// }


	// @Bean
	// public Server grpcServer(AcquirerToIssuerCardTransactionsServiceController service) {
	// 	return ServerBuilder.forPort(9090)
	// 			.addService(service)
	// 			.build();
	// }
}
