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
  - Nombre del responsable del bug.
  - Descripción del bug.
  - Severidad: **Crítica**, **Alta**, **Media**, **Baja**.
  - Módulo afectado.
  - Estado: Todos los bugs inician con estado ABIERTO.
  - Fecha de creación.
  - Prioridad: **Alta**, **Media**, **Baja**.
- Generar automáticamente un identificador único.

### 🔹 **Listar Bugs**
- Permitir listar por:
  - **Fecha de creación**.
  - **ID** del bug (Ascendente).

### 🔹 **Buscar Bugs**
- Permitir búsquedas por:
  - **ID** del bug.
  - **Nombre** Nombre del responsable.
  - **Estado** (Pendiente, Resuelto, etc.).
  - **Severidad** (Crítica, Alta, Media, Baja.).

### 🔹 **Modificar Bug**
- Actualizar los atributos de un bug, como:
  - Nombre.
  - Descripción.
  - Estado.
  - Prioridad.

### 🔹 **Eliminar Bug**
- Eliminar bugs registrados a partir de su ID único.

### 🔹 **Generar Informes**
- Generar informes personalizados como:
  - Informe por estado.
  - Informe por responsables.
  - Informe por severidad
- Cada uno, informando cantidad de bugs correspondientes.

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

1. **Registrar Bug**.
2. **Listar Bug**.
3. **Buscar Bug**.
4. **Modificar Bug**.
5. **Eliminar Bug**.
6. **Informes**.
7. **Salir**.

