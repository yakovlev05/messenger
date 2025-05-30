package ru.yakovlev05.school.flash.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.yakovlev05.school.flash.props.KafkaTopicProps;
import ru.yakovlev05.school.flash.props.NotificationTemplatesProps;
import ru.yakovlev05.school.flash.props.SecurityProps;
import ru.yakovlev05.school.flash.props.TicketProps;

@EnableConfigurationProperties({TicketProps.class, SecurityProps.class, KafkaTopicProps.class, NotificationTemplatesProps.class})
@Configuration
public class AppConfig {
}
