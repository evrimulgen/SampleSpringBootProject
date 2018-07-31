package tr.com.dev.haliYikama.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.dev.haliYikama.server.persist.models.MusteriSiparis;
import tr.com.dev.haliYikama.server.utils.BaseController;

/**
 * Created by ramazancesur on 7/31/18.
 */

@RestController
@RequestMapping("/musteriSiparis")
public class MusteriSiparisController extends BaseController<MusteriSiparis> {

}
