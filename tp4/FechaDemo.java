import java.util.*;
import java.text.*;
public class FechaDemo{
 public static void main(String a[]){
 // con Date
 Date f_Date = new Date();
 System.out.println("Fecha actual con Date: " + f_Date);
 // con Calendar
 Calendar f_Calendar = Calendar.getInstance();
 System.out.println("Fecha actual con Calendar: "
 + f_Calendar.get(Calendar.DATE) + "/"
 + (f_Calendar.get(Calendar.MONTH)+1) + "/"
 + f_Calendar.get(Calendar.YEAR));
 // establecer una fecha determinada con Calendar
 f_Calendar.set(2006, 9, 16);
 // obtener un Date desde un Calendar
 f_Date=f_Calendar.getTime();
 // obtener un Calendar desde un Date
 f_Calendar.setTime(f_Date);
 // crear objeto con formato deseado. Aplicar método format(Date)
 DateFormat formato1 = DateFormat.getDateInstance(DateFormat.FULL);
 System.out.println("Fecha formateada DateFormat: " + formato1.format(f_Date));
 SimpleDateFormat formato2=new SimpleDateFormat("dd.MM.yy");
 System.out.println("Fecha formateada SimpleDateFormat: " + formato2.format(f_Date));
 // sumar/restar días, meses, años
 f_Calendar.add(Calendar.DATE, -5);
 f_Calendar.add(Calendar.MONTH, 2);
 System.out.println("Fecha -5 días + 2 meses: " + formato2.format(f_Calendar.getTime()));
// otros métodos para sumar días
 f_Calendar.add(Calendar.DAY_OF_YEAR, -5);
 System.out.println("Otra Forma ***** :Fecha -5 días:" + formato2.format(f_Calendar.getTime()));
 f_Calendar.add(Calendar.DAY_OF_MONTH, 2);
 System.out.println("Otra Forma ***** :Fecha +2 días:" + formato2.format(f_Calendar.getTime()));
// comparar fechas
 Calendar f1=Calendar.getInstance();
 Calendar f2=Calendar.getInstance();
 f1.set(2006, 9, 16);
 f2.set(2006, 10, 6);
 if(f1.equals(f2)){
 System.out.println("Fechas iguales");
 }
 if(f1.after(f2)){
 System.out.println("f1 > f2");
 }
 if(f1.before(f2)){
 System.out.println("f1 < f2");
 }
 }}