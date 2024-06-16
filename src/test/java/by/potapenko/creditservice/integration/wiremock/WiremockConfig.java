package by.potapenko.creditservice.integration.wiremock;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
@WireMockTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class WiremockConfig {
    @RegisterExtension
    public static WireMockExtension wm =
            WireMockExtension.newInstance()
                    .options(wireMockConfig().dynamicPort())
                    .build();
    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("feign.client.url", wm::baseUrl);
    }
}
