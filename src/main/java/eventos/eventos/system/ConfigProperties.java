package eventos.eventos.system;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties(prefix = "var")
public class ConfigProperties {

    private final int URC_EXPIRATION_MIN;

    public ConfigProperties(
            @Value("${var.URC_EXPIRATION_MIN}") int urcExpirationMin
    ) {
        this.URC_EXPIRATION_MIN = urcExpirationMin;
    }
}
