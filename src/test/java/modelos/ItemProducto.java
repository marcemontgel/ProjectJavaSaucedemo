package modelos;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("items")
public class ItemProducto {
    @ExcelCellName("NOMBRE")
    private String nombre;
    @ExcelCellName("PRECIO")
    private String precio;

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }
}
