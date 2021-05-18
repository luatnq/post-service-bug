package postservice.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import postservice.ratelimiting.RateLimitInterceptor;

import java.time.Duration;

@Configuration
public class RateConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        Refill refill = Refill.intervally(1000, Duration.ofSeconds(2));
        Bandwidth limit = Bandwidth.classic(1000, refill);
        Bucket bucket = Bucket4j.builder().addLimit(limit).build();
        registry.addInterceptor(new RateLimitInterceptor(bucket, 1))
                .addPathPatterns("/api/v1/posts");
        registry.addInterceptor(new RateLimitInterceptor(bucket, 1))
                .addPathPatterns("/api/v1/*/*");
    }
}