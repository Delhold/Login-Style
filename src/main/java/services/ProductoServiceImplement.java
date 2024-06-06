package services;
//  Created by IntelliJ IDEA.
//  Estudiante: Dario Verdezoto
//  Descripcion: Estilos
//  To change this template use File | Settings | File Templates.

import models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImplement implements ProductoService {


    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1, "laptop", "computación", "hp i5",254),
                new Producto(2,"audifonos","implementos","corsair-g56",50),
                new Producto(3,"mouse","implementos","hyper-x",25),
                new Producto(4,"SDD","computacion","500gb",100),
                new Producto(5,"monitor","hardware","1Tb",60));
    };
}
