package com.ciudadania.configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfiguration {

    @Bean
    fun apiInfo(): OpenAPI {
        return OpenAPI().info(
            Info().title("Test API documentation")
                .description("Documentation for Test Ciudadania API")
                .version("v1")
                .contact(getContactDetails())
                .license(getLicenseDetails())
        )
    }

    private fun getContactDetails(): Contact {
        return Contact().name("Chulls").email("contact@email.con").url("https://website.com")
    }

    private fun getLicenseDetails(): License {
        return License().name("License name").url("https://license-url.com")
    }

}