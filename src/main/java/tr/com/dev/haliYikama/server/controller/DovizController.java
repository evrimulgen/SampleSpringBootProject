package tr.com.dev.haliYikama.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.dev.haliYikama.server.persist.models.Doviz;
import tr.com.dev.haliYikama.server.utils.BaseController;

@RestController
@RequestMapping("/doviz")
public class DovizController extends BaseController<Doviz> {

}
