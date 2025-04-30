package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.dto.ProductoDto;
import com.accesoriosApolo.ws.util.ProductoUtilidades;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoDao {

    public ProductoDao(){
        ProductoUtilidades.iniciarLista();
    }

    public static ProductoDto consultarProductoIndividual(String referencia) {
        for (ProductoDto p : ProductoUtilidades.listaProductos) {
            if (p.getReferencia().equals(referencia)) {
                ProductoDto productoDto = new ProductoDto();
                productoDto.setReferencia(p.getReferencia());
                productoDto.setNombre(p.getNombre());
                productoDto.setDescripcion(p.getDescripcion());
                productoDto.setTalla(p.getTalla());
                productoDto.setStock(p.getStock());
                productoDto.setPrecio_unitario(p.getPrecio_unitario());
                productoDto.setPeso_unidad(p.getPeso_unidad());
                productoDto.setFicha_tecnica(p.getFicha_tecnica());
                productoDto.setPrecio_descuento(p.getPrecio_descuento());
                productoDto.setFk_categoria(p.getFk_categoria());
                return productoDto;
            }
        }
        return null;
    }

    public List<ProductoDto> obtenerListaProductos() {
        return ProductoUtilidades.listaProductos;
    }

    public ProductoDto registrarProducto(ProductoDto productoDto){
        for (ProductoDto obj: ProductoUtilidades.listaProductos){
            if (obj.getReferencia().equals(productoDto.getReferencia())){
                return null;
            }
        }

        ProductoUtilidades.listaProductos.add(productoDto);

        return productoDto;
    }

    public ProductoDto actualizarProducto(ProductoDto productoDto){

        for (ProductoDto obj: ProductoUtilidades.listaProductos){
            if (obj.getReferencia().equals(productoDto.getReferencia())){
                obj.setReferencia(productoDto.getReferencia());
                obj.setNombre(productoDto.getNombre());
                obj.setDescripcion(productoDto.getDescripcion());
                obj.setTalla(productoDto.getTalla());
                obj.setStock(productoDto.getStock());
                obj.setPrecio_unitario(productoDto.getPrecio_unitario());
                obj.setPeso_unidad(productoDto.getPeso_unidad());
                obj.setFicha_tecnica(productoDto.getFicha_tecnica());
                obj.setPrecio_descuento(productoDto.getPrecio_descuento());
                obj.setFk_categoria(productoDto.getFk_categoria());

                return obj;
            }
        }
        return null;
    }

    public boolean eliminarProducto(ProductoDto productoDto){
        for (int i = 0; i < ProductoUtilidades.listaProductos.size(); i++) {
            if (ProductoUtilidades.listaProductos.get(i).getReferencia().equals(productoDto.getReferencia())){
                ProductoUtilidades.listaProductos.remove(i);
                return true;
            }
        }
        return false;
    }

}
