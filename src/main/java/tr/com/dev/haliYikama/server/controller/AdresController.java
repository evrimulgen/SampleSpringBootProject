package tr.com.dev.haliYikama.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tr.com.dev.haliYikama.server.persist.models.Adres;
import tr.com.dev.haliYikama.server.utils.BaseController;

@Controller
@RequestMapping(value = "/address/")
public class AdresController extends BaseController<Adres> {


}
