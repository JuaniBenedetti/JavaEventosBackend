package eventos.eventos.Services.salones;

import eventos.eventos.Model.Salon;
import eventos.eventos.dao.salon.SalonDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javassist.NotFoundException;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SalonesServicesImpl implements SalonesService{

    private final SalonDao salaDao;

    @Override
    public List<Salon> findSalones(){
        return salaDao.findAll();
    }

    @Override
    public Salon findSalonById(long id) {return salaDao.findById(id).get();}

    @Override
    public Salon saveSalon(Salon salon) throws Exception{
        return salaDao.save(salon);
    }
    @Override
    public Salon updateSalon(Salon salon) throws  Exception{

        Salon salonDB = salaDao.findById(salon.getIdSalon())
                .orElseThrow(() -> new NotFoundException("No existe el salon"));

        return salaDao.save(salon);
    }

    @Override
    public void deleteById(long id) throws Exception {
        Salon salonDB = salaDao.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe el salon"));
        salaDao.deleteById(id);
    }
}
