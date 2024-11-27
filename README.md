# Bug Tracker

## 📋 Descripción del Proyecto

**Bug Tracker** es un sistema diseñado para registrar, gestionar y consultar errores (bugs) reportados en entornos de desarrollo. Este programa utiliza un diseño basado en **Programación Orientada a Objetos (POO)** y cuenta con menús interactivos que facilitan la interacción del usuario. Proporciona herramientas intuitivas para crear, buscar, modificar y listar bugs, asegurando una gestión eficiente y organizada.

---

## 🎯 Objetivos del Proyecto

### Implementar **POO**
- Uso de encapsulamiento, herencia, polimorfismo y abstracción.
- Aplicación de buenas prácticas de codificación.

### Cumplir los requisitos funcionales
- **Registrar**: Crear nuevas incidencias con identificadores únicos.
- **Gestionar**: Listar, buscar, ordenar, modificar y eliminar bugs.
- **Validar**: Manejar excepciones y asegurar que los datos ingresados sean válidos.

### Facilitar la interacción del usuario
- Uso de menús intuitivos mediante `JOptionPane`.
- Generación de informes personalizados para los usuarios.

### Promover el uso de pruebas
- Implementar pruebas unitarias y validaciones robustas.

---

## 🛠️ Funcionalidades Principales

### 🔹 **Registrar Bug**
- Ingresar información clave como:
  - Descripción del bug.
  - Estado: **Pendiente**, **Resuelto**, etc.
  - Prioridad: **Alta**, **Media**, **Baja**.
  - Fecha de creación.
- Generar automáticamente un identificador único.

### 🔹 **Listar Bugs**
- Mostrar una lista general de todos los bugs registrados con su información detallada.

### 🔹 **Buscar Bugs**
- Permitir búsquedas por:
  - **ID** del bug.
  - **Estado** (Pendiente, Resuelto, etc.).

### 🔹 **Ordenar Bugs**
- Ordenar las incidencias según:
  - **Prioridad** (Alta, Media, Baja).
  - **Fecha de creación**.

### 🔹 **Modificar Bug**
- Actualizar los atributos de un bug, como:
  - Nombre.
  - Estado.
  - Descripción.
  - Prioridad.

### 🔹 **Eliminar Bug**
- Eliminar bugs registrados a partir de su ID único.

### 🔹 **Generar Informes**
- Crear reportes personalizados como:
  - Listar bugs **pendientes** ordenados por prioridad.
  - Contar el número total de bugs registrados.

---

## 📂 Estructura del Proyecto

### 📦 Paquetes
1. **model**: Contiene las clases que representan las entidades principales del sistema.
2. **service**: Implementa la lógica del negocio, como la gestión de bugs.
3. **view**: Maneja la interacción con el usuario mediante menús y ventanas.
4. **utils**: Donde se encuentran clases utiles para el desarrollo del sistema.

---

## 🧩 Menú Tentativo

El sistema presenta un menú interactivo con las siguientes opciones:

1. **Registrar Incidencia** (Seleccionar tipo: Bug).
2. **Listar todas las Incidencias**.
3. **Buscar Incidencia** por ID o Estado.
4. **Ordenar Incidencias** por Prioridad o Fecha.
5. **Modificar una Incidencia**.
6. **Eliminar una Incidencia**.
7. **Generar Informe Personalizado**.
8. **Salir**.

