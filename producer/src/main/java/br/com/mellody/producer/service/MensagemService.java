package br.com.mellody.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    private static final Logger logger = LoggerFactory.getLogger(MensagemService.class);

    @Value("${topic.melody-search}")
    private String topicoMelodySearch; // Remover 'static'

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MensagemService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String msg) {
        logger.info("Mensagem -> {}.", msg);
        kafkaTemplate.send(topicoMelodySearch, msg);
    }
}
