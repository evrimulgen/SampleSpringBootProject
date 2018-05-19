package tr.com.dev.haliYikama.server.utils.interfaces;

import tr.com.dev.haliYikama.server.utils.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ramazancesur on 5/19/18.
 */
public interface IGenericService<T extends BaseEntity, K extends Serializable> {

    public void saveOrUpdate(T entity);

    public List<T> getAll();

    public T get(K id) throws Exception;

    public boolean add(T entity);

    public boolean update(T entity);

    public boolean remove(T entity);

    public boolean remove(K id);
}
