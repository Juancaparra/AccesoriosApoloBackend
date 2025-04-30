package com.accesoriosApolo.ws.service;

import com.accesoriosApolo.ws.dao.ProductoDao;
import com.accesoriosApolo.ws.dto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoDao productoDao;

    @Autowired
    public ProductoService(ProductoDao productoDao){
        this.productoDao=productoDao;
    }

    public ProductoDto obtenerProdutoPorReferencia(String referencia) {
        return ProductoDao.consultarProductoIndividual(referencia);
    }

    public List<ProductoDto> obtenerListaProductos(){
        return productoDao.obtenerListaProductos();
    }

    public ProductoDto registrarProducto(ProductoDto productoDto){

        //CategoriaDto categoriaDto= categoriaDao.consultarCategoriaIndividual(productoDto.getFk_categoria());

        if (productoDto==null || productoDto.getReferencia()==null || productoDto.getReferencia().isEmpty()
                /*|| categoriaDto==null*/){
            return null;
        }

        return productoDao.registrarProducto(productoDto);
    }

    public ProductoDto actualizarProducto(ProductoDto productoDto){
        if (productoDto==null ||productoDto.getReferencia()==null || productoDto.getReferencia().isEmpty()){
            return null;
        }
        //CategoriaDto categoriaDto= categoriaDao.consultarCategoriaIndividual(productoDto.getReferencia());

        ProductoDto categoriaExistente= ProductoDao.consultarProductoIndividual(productoDto.getReferencia());
        if (categoriaExistente ==null /*|| ==null*/){
            return null;
        }
        return productoDao.actualizarProducto(productoDto);
    }

    public boolean eliminarProducto(String referencia){

        ProductoDto productoExistente= ProductoDao.consultarProductoIndividual(referencia);

        if (productoExistente ==null){
            return false;
        }
        return productoDao.eliminarProducto(productoExistente);
    }

}
