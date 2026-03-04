# Práctica 2: Reconocimiento de palabras con Autómatas Finitos Deterministas

**UAEH - ICBI**  
**Licenciatura en Ciencias Computacionales | 6° “3”**  
**Alumno:** José David Jácome Cayetano  
**Catedrático:** Eduardo Cornejo Velázquez  

---

# 1. Ejercicio 1

## Lenguaje
L = {0x | x ∈ {0,1}*}

## Tabla de Elementos del AFD

| Elementos | Valores |
|------------|----------|
| Σ | {0,1} |
| Q | {q₀, q₁, q₂} |
| δ | f(q₀,0)=q₁ <br> f(q₀,1)=q₂ <br> f(q₁,0)=q₁ <br> f(q₁,1)=q₁ <br> f(q₂,0)=q₂ <br> f(q₂,1)=q₂ |
| q₀ | q₀ |
| F | {q₁} |

## Tabla de Transición

| Estado | 0 | 1 |
|---------|---|---|
| ⇝q₀ | q₁ | q₂ |
| ⋇q₁ | q₁ | q₁ |
| q₂ | q₂ | q₂ |

![Diagrama AFD 10](imagenes/afd1.png)

---

# 2. Ejercicio 2

## Lenguaje
L = {x1 | x ∈ {0,1}+}

## Tabla de Elementos del AFD

| Elementos | Valores |
|------------|----------|
| Σ | {0,1} |
| Q | {q₀, q₁, q₂} |
| δ | f(q₀,0)=q₁ <br> f(q₀,1)=q₁ <br> f(q₁,0)=q₁ <br> f(q₁,1)=q₂ <br> f(q₂,0)=q₁ <br> f(q₂,1)=q₂ |
| q₀ | q₀ |
| F | {q₂} |

## Tabla de Transición

| Estado | 0 | 1 |
|---------|---|---|
| ⇝q₀ | q₁ | q₁ |
| q₁ | q₁ | q₂ |
| ⋇q₂ | q₁ | q₂ |

![Diagrama AFD 2](imagenes/afd2.png)

---

# 3. Ejercicio 3

## Lenguaje
L = {x01y | x,y ∈ {0,1}*}

## Tabla de Elementos del AFD

| Elementos | Valores |
|------------|----------|
| Σ | {0,1} |
| Q | {q₀, q₁, q₂, q₃} |
| δ | f(q₀,0)=q₁ <br> f(q₀,1)=q₃ <br> f(q₁,0)=q₁ <br> f(q₁,1)=q₂ <br> f(q₂,0)=q₂ <br> f(q₂,1)=q₂ <br> f(q₃,0)=q₁ <br> f(q₃,1)=q₃ |
| q₀ | q₀ |
| F | {q₂} |

## Tabla de Transición

| Estado | 0 | 1 |
|---------|---|---|
| ⇝q₀ | q₁ | q₃ |
| q₁ | q₁ | q₂ |
| ⋇q₂ | q₂ | q₂ |
| q₃ | q₁ | q₃ |

![Diagrama AFD 3](imagenes/afd3.png)

---

# 4. Ejercicio 4

## Lenguaje
L = {x110y | x,y ∈ {0,1}*}

## Tabla de Elementos del AFD

| Elementos | Valores |
|------------|----------|
| Σ | {0,1} |
| Q | {q₀, q₁, q₂, q₃} |
| δ | f(q₀,0)=q₀ <br> f(q₀,1)=q₁ <br> f(q₁,0)=q₀ <br> f(q₁,1)=q₂ <br> f(q₂,0)=q₁ <br> f(q₂,1)=q₃ <br> f(q₃,0)=q₃ <br> f(q₃,1)=q₃ |
| q₀ | q₀ |
| F | {q₃} |

## Tabla de Transición

| Estado | 0 | 1 |
|---------|---|---|
| ⇝q₀ | q₀ | q₁ |
| q₁ | q₀ | q₂ |
| q₂ | q₁ | q₃ |
| ⋇q₃ | q₃ | q₃ |

![Diagrama AFD 4](imagenes/afd4.png)

---

# 5. Ejercicio 5

## Lenguaje
L = {acxab | x ∈ {a,b,c}*}

## Tabla de Elementos del AFD

| Elementos | Valores |
|------------|----------|
| Σ | {a,b,c} |
| Q | {q₀, q₁, q₂, q₃, q₄} |
| δ | f(q₀,a)=q₁ <br> f(q₁,c)=q₂ <br> f(q₂,a)=q₃ <br> f(q₂,b)=q₂ <br> f(q₂,c)=q₂ <br> f(q₃,a)=q₃ <br> f(q₃,b)=q₄ <br> f(q₃,c)=q₂ <br> f(q₄,a)=q₃ <br> f(q₄,b)=q₂ <br> f(q₄,c)=q₂ |
| q₀ | q₀ |
| F | {q₄} |

## Tabla de Transición

| Estado | a | b | c |
|---------|---|---|---|
| ⇝q₀ | q₁ | ∅ | ∅ |
| q₁ | ∅ | ∅ | q₂ |
| q₂ | q₃ | q₂ | q₂ |
| q₃ | q₃ | q₄ | q₂ |
| ⋇q₄ | q₃ | q₂ | q₂ |

![Diagrama AFD 5](imagenes/afd5.png)

---

# 6. Ejercicio 6

## Lenguaje
L = {acxz | x ∈ {a,b,c}*  y  z ≠ ab}

## Tabla de Elementos del AFD

| Elementos | Valores |
|------------|----------|
| Σ | {a,b,c} |
| Q | {q₀, q₁, q₂, q₃, q₄} |
| δ | f(q₀,a)=q₁ <br> f(q₁,c)=q₂ <br> f(q₂,a)=q₃ <br> f(q₂,b)=q₂ <br> f(q₂,c)=q₂ <br> f(q₃,a)=q₃ <br> f(q₃,b)=q₄ <br> f(q₃,c)=q₂ <br> f(q₄,a)=q₃ <br> f(q₄,b)=q₂ <br> f(q₄,c)=q₂ |
| q₀ | q₀ |
| F | {q₂, q₃} |

## Tabla de Transición

| Estado | a | b | c |
|---------|---|---|---|
| ⇝q₀ | q₁ | ∅ | ∅ |
| q₁ | ∅ | ∅ | q₂ |
| ⋇q₂ | q₃ | q₂ | q₂ |
| ⋇q₃ | q₃ | q₄ | q₂ |
| q₄ | q₃ | q₂ | q₂ |

![Diagrama AFD 6](imagenes/afd6.png)

---

# 7. Ejercicio 7

## Lenguaje
L = {acbxz | x ∈ {a,b,c,d}*  y  z ≠ bd}

## Tabla de Elementos del AFD

| Elementos | Valores |
|------------|----------|
| Σ | {a,b,c,d} |
| Q | {q₀, q₁, q₂, q₃, q₄, q₅} |
| δ | f(q₀,a)=q₁ <br> f(q₁,c)=q₂ <br> f(q₂,b)=q₃ <br> f(q₃,a)=q₃ <br> f(q₃,b)=q₄ <br> f(q₃,c)=q₃ <br> f(q₃,d)=q₃ <br> f(q₄,a)=q₃ <br> f(q₄,b)=q₄ <br> f(q₄,c)=q₃ <br> f(q₄,d)=q₅ <br> f(q₅,a)=q₃ <br> f(q₅,b)=q₄ <br> f(q₅,c)=q₃ <br> f(q₅,d)=q₃ |
| q₀ | q₀ |
| F | {q₃, q₄} |

## Tabla de Transición

| Estado | a | b | c | d |
|---------|---|---|---|---|
| ⇝q₀ | q₁ | ∅ | ∅ | ∅ |
| q₁ | ∅ | ∅ | q₂ | ∅ |
| q₂ | ∅ | q₃ | ∅ | ∅ |
| ⋇q₃ | q₃ | q₄ | q₃ | q₃ |
| ⋇q₄ | q₃ | q₄ | q₃ | q₅ |
| q₅ | q₃ | q₄ | q₃ | q₃ |

![Diagrama AFD 7](imagenes/afd7.png)

---

# 8. Ejercicio 8

## Lenguaje
L = {cabaxz | x ∈ {a,b,c,d}*  y  z ≠ ab}

## Tabla de Elementos del AFD

| Elementos | Valores |
|------------|----------|
| Σ | {a,b,c,d} |
| Q | {q₀, q₁, q₂, q₃, q₄, q₅, q₆} |
| δ | f(q₀,c)=q₁ <br> f(q₁,a)=q₂ <br> f(q₂,b)=q₃ <br> f(q₃,a)=q₄ <br> f(q₄,a)=q₅ <br> f(q₄,b)=q₄ <br> f(q₄,c)=q₄ <br> f(q₄,d)=q₄ <br> f(q₅,a)=q₅ <br> f(q₅,b)=q₆ <br> f(q₅,c)=q₄ <br> f(q₅,d)=q₄ <br> f(q₆,a)=q₅ <br> f(q₆,b)=q₄ <br> f(q₆,c)=q₄ <br> f(q₆,d)=q₄ |
| q₀ | q₀ |
| F | {q₄, q₅} |

## Tabla de Transición

| Estado | a | b | c | d |
|---------|---|---|---|---|
| ⇝q₀ | ∅ | ∅ | q₁ | ∅ |
| q₁ | q₂ | ∅ | ∅ | ∅ |
| q₂ | ∅ | q₃ | ∅ | ∅ |
| q₃ | q₄ | ∅ | ∅ | ∅ |
| ⋇q₄ | q₅ | q₄ | q₄ | q₄ |
| ⋇q₅ | q₅ | q₆ | q₄ | q₄ |
| q₆ | q₅ | q₄ | q₄ | q₄ |

![Diagrama AFD 8](imagenes/afd8.png)

---

# 9. Ejercicio 9

## Lenguaje
L = { aⁿ (cb)ᵐ | n > 0  y  m > 0 }

## Tabla de Elementos del AFD

| Elementos | Valores |
|------------|----------|
| Σ | {a,b,c} |
| Q | {q₀, q₁, q₂, q₃} |
| δ | f(q₀,a)=q₁ <br> f(q₁,a)=q₁ <br> f(q₁,c)=q₂ <br> f(q₂,c)=q₂ <br> f(q₂,b)=q₃ <br> f(q₃,b)=q₃ |
| q₀ | q₀ |
| F | {q₃} |

## Tabla de Transición

| Estado | a | b | c |
|---------|---|---|---|
| ⇝q₀ | q₁ | ∅ | ∅ |
| q₁ | q₁ | ∅ | q₂ |
| q₂ | ∅ | q₃ | q₂ |
| ⋇q₃ | ∅ | q₃ | ∅ |

![Diagrama AFD 9](imagenes/afd9.png)

---

# 10. Ejercicio 10

## Lenguaje
L = { (ac)^(3m)  |  x ∈ {a,b}*  y  la cantidad de b es par,  m ≥ 0 }

## Tabla de Elementos del AFD

| Elementos | Valores |
|------------|----------|
| Σ | {a,b,c} |
| Q | {q₀, q₁, q₂, q₃, q₄, q₅} |
| δ | f(q₀,a)=q₀ <br> f(q₀,b)=q₁ <br> f(q₀,c)=q₃ <br> f(q₁,a)=q₁ <br> f(q₁,b)=q₂ <br> f(q₂,a)=q₂ <br> f(q₂,b)=q₁ <br> f(q₂,c)=q₃ <br> f(q₃,c)=q₄ <br> f(q₄,c)=q₅ <br> f(q₅,c)=q₃ |
| q₀ | q₀ |
| F | {q₀, q₂, q₅} |

## Tabla de Transición

| Estado | a | b | c |
|---------|---|---|---|
| ⇝⋇q₀ | q₀ | q₁ | q₃ |
| q₁ | q₁ | q₂ | ∅ |
| ⋇q₂ | q₂ | q₁ | q₃ |
| q₃ | ∅ | ∅ | q₄ |
| q₄ | ∅ | ∅ | q₅ |
| ⋇q₅ | ∅ | ∅ | q₃ |

![Diagrama AFD 10](imagenes/afd10.png)

---

# Preguntas Teóricas

## ¿Cuáles son los elementos que definen un AFD?

Un AFD se define como la 5-tupla (Q, Σ, δ, q₀, F).

## ¿Cuál es la utilidad de la tabla de transiciones?

Permite visualizar y verificar formalmente el comportamiento del autómata.

## ¿Qué importancia tienen los diagramas?

Facilitan el diseño conceptual y la comprensión visual.

## ¿Cuáles son las ventajas de la simulación?

Permite validar cadenas y comprobar el lenguaje reconocido.

---

# Bibliografía

- Giró, J. et al. (2015). *Lenguajes formales y teoría de autómatas*. Alfaomega.
- Ruiz Catalán, J. (2010). *Compiladores: teoría e implementación*. Alfaomega.
- Brookshear, J. G. (1995). *Teoría de la Computación*. Addison-Wesley.
