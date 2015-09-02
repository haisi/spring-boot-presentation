package ch.fhnw;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties("customer")
public class CustomerProperties {

    @NotNull
    private String evil;

    public String getEvil() {
        return evil;
    }

    public void setEvil(String evil) {
        this.evil = evil;
    }
}
