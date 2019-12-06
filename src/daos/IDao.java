/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;

/**
 *
 * @author demen
 */
public interface IDao<E> {

    public boolean save(E entity);

    public boolean delete(E entity);

    public List<E> select(String key);

    public List<E> search(String tabel, String field, String key);

    public E selectById(String tabel, String field, String key);

    public E selectByName(String table, String field, String key);

}
