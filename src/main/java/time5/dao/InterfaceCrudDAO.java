package time5.dao;

import java.util.List;

public interface InterfaceCrudDAO<T> {

	void insert(T obj);

	void update(T obj);

	void delete(int id);
	
	List<T> recupera();
	
	T recupera(int id);

}
