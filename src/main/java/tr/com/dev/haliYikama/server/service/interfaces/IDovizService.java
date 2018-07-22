package tr.com.dev.haliYikama.server.service.interfaces;

import tr.com.dev.haliYikama.server.persist.models.Doviz;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericService;

public interface IDovizService extends IGenericService<Doviz, Long> {

    Doviz getDovizKodunaGore(String dovizKodu);
}
