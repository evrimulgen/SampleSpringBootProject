package tr.com.dev.haliYikama.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.dev.haliYikama.server.persist.models.Musteri;
import tr.com.dev.haliYikama.server.utils.BaseController;

/**
 * Created by ramazancesur on 7/31/18.
 */
@RestController
@RequestMapping("/musteri")
public class MusteriController extends BaseController<Musteri> {

}
