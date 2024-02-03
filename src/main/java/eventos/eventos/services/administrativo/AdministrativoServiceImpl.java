package eventos.eventos.services.administrativo;

import eventos.eventos.dao._CRUD.CRUDDao;
import eventos.eventos.dao.administrativo.AdministrativoDao;
import eventos.eventos.model.Administrativo;
import eventos.eventos.model.Usuario;
import eventos.eventos.services._CRUD.CRUDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdministrativoServiceImpl extends CRUDServiceImpl<Administrativo> implements AdministrativoService{

    private final AdministrativoDao administrativoDao;

    public AdministrativoServiceImpl(AdministrativoDao administrativoDao) {
        super(administrativoDao);
        this.administrativoDao = administrativoDao;
    }

    @Override
    public Administrativo findByUsuario(Usuario usuario) throws Exception {
        return administrativoDao.findByUsuario(usuario);
    }
}
