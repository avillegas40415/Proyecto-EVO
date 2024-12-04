package com.EVO.gym.crud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CRUDManager {

    // Clase Usuario
    public static class Usuario {
        private int id;
        private String nombre;
        private String correo;
        private String contrasena;
        private boolean activo;

        public Usuario(int id, String nombre, String correo, String contrasena, boolean activo) {
            this.id = id;
            this.nombre = nombre;
            this.correo = correo;
            this.contrasena = contrasena;
            this.activo = activo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }

        public boolean isActivo() {
            return activo;
        }

        public void setActivo(boolean activo) {
            this.activo = activo;
        }
    }

    // CRUD para Usuarios
    public static class UsuarioCRUD {
        private List<Usuario> usuarios = new ArrayList<>();

        public void crearUsuario(Usuario usuario) {
            usuarios.add(usuario);
        }

        public Usuario leerUsuario(int id) {
            return usuarios.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        }

        public void actualizarUsuario(Usuario usuarioActualizado) {
            Usuario usuario = leerUsuario(usuarioActualizado.getId());
            if (usuario != null) {
                usuario.setNombre(usuarioActualizado.getNombre());
                usuario.setCorreo(usuarioActualizado.getCorreo());
                usuario.setContrasena(usuarioActualizado.getContrasena());
                usuario.setActivo(usuarioActualizado.isActivo());
            }
        }

        public void eliminarUsuario(int id) {
            usuarios.removeIf(u -> u.getId() == id);
        }

        public List<Usuario> obtenerTodosLosUsuarios() {
            return usuarios;
        }
    }

    // Clase Producto
    public static class Producto {
        private int id;
        private String nombre;
        private String descripcion;
        private double precio;
        private int stock;

        public Producto(int id, String nombre, String descripcion, double precio, int stock) {
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.stock = stock;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }
    }

    // CRUD para Productos
    public static class ProductoCRUD {
        private List<Producto> productos = new ArrayList<>();

        public void crearProducto(Producto producto) {
            productos.add(producto);
        }

        public Producto leerProducto(int id) {
            return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        }

        public void actualizarProducto(Producto productoActualizado) {
            Producto producto = leerProducto(productoActualizado.getId());
            if (producto != null) {
                producto.setNombre(productoActualizado.getNombre());
                producto.setDescripcion(productoActualizado.getDescripcion());
                producto.setPrecio(productoActualizado.getPrecio());
                producto.setStock(productoActualizado.getStock());
            }
        }

        public void eliminarProducto(int id) {
            productos.removeIf(p -> p.getId() == id);
        }

        public List<Producto> obtenerTodosLosProductos() {
            return productos;
        }
    }

    // Clase Noticia
    public static class Noticia {
        private int id;
        private String titulo;
        private String contenido;
        private Date fecha;

        public Noticia(int id, String titulo, String contenido, Date fecha) {
            this.id = id;
            this.titulo = titulo;
            this.contenido = contenido;
            this.fecha = fecha;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getContenido() {
            return contenido;
        }

        public void setContenido(String contenido) {
            this.contenido = contenido;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }
    }

    // CRUD para Noticias
    public static class NoticiaCRUD {
        private List<Noticia> noticias = new ArrayList<>();

        public void crearNoticia(Noticia noticia) {
            noticias.add(noticia);
        }

        public Noticia leerNoticia(int id) {
            return noticias.stream().filter(n -> n.getId() == id).findFirst().orElse(null);
        }

        public void actualizarNoticia(Noticia noticiaActualizada) {
            Noticia noticia = leerNoticia(noticiaActualizada.getId());
            if (noticia != null) {
                noticia.setTitulo(noticiaActualizada.getTitulo());
                noticia.setContenido(noticiaActualizada.getContenido());
                noticia.setFecha(noticiaActualizada.getFecha());
            }
        }

        public void eliminarNoticia(int id) {
            noticias.removeIf(n -> n.getId() == id);
        }

        public List<Noticia> obtenerTodasLasNoticias() {
            return noticias;
        }
    }
}