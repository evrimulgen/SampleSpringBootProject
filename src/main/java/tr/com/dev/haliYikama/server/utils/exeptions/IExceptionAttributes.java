package tr.com.dev.haliYikama.server.utils.exeptions;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by ramazancesur on 5/19/18.
 */
public interface IExceptionAttributes {
    Map<String, Object> getExceptionAttributes(Exception exception, HttpServletRequest httpRequest,
                                               HttpStatus httpStatus);
}
