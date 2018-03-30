package pack2;

import java.util.List;
import org.springframework.dao.DataAccessException;

public interface SangpumInter {
	List<SangpumDto> selectList() throws DataAccessException;
}
