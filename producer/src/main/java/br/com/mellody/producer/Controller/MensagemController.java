package br.com.mellody.producer.Controller;

import br.com.mellody.producer.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    MensagemService mensagemService;


    @PostMapping
    public ResponseEntity<String> enviarMensagem(@RequestBody String msg){
        mensagemService.sendMessage(msg);
        return ResponseEntity.ok().body("Mensagem enviada com sucesso" + msg);
    }
}
