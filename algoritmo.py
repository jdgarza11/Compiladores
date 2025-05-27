import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D

def read_pof_file(filename):
    """Lee archivo .pof y devuelve array numpy"""
    points = []
    with open(filename, 'r') as f:
        header = f.readline().strip().split()
        n_points = int(header[1])
        dim = int(header[2])
        
        for line in f:
            if line.startswith('#'):
                continue
            points.append([float(x) for x in line.strip().split()])
    
    return np.array(points), dim

# Leer archivos .pof
file_2d = "ZCAT1_200_02D.pof"  # Archivo con dimensión 2
file_3d = "ZCAT1_200_03D.pof"  # Archivo con dimensión 3

points_2d, dim2 = read_pof_file(file_2d)
points_3d, dim3 = read_pof_file(file_3d)

# Función de ejemplo para subconjunto (usar tu algoritmo real)
def find_optimal_subset(points, mu, s):
    # Implementación real de HybRieszMin aquí
    return np.random.choice(len(points), mu, replace=False)  # Placeholder

# Encontrar subconjuntos
mu = 50
optimal_subset_2d = find_optimal_subset(points_2d, mu, dim2+1)
optimal_subset_3d = find_optimal_subset(points_3d, mu, dim3+1)

# Crear figura
plt.figure(figsize=(15, 6))

# Gráfico 2D
plt.subplot(121)
plt.scatter(points_2d[:,0], points_2d[:,1], 
            c='lightgray', alpha=0.5, s=30, label='Todos los puntos')
plt.scatter(points_2d[optimal_subset_2d,0], points_2d[optimal_subset_2d,1],
            c='red', edgecolor='black', s=60, 
            linewidths=1.5, label='Subconjunto óptimo')

plt.title(f'Instancia 2D ({len(points_2d)} puntos)\nSubconjunto: {mu} puntos')
plt.xlabel('Coordenada X')
plt.ylabel('Coordenada Y')
plt.grid(True, linestyle='--', alpha=0.3)
plt.legend(loc='upper right')

# Gráfico 3D
ax = plt.subplot(122, projection='3d')
ax.scatter(points_3d[:,0], points_3d[:,1], points_3d[:,2],
           c='lightgray', alpha=0.5, s=30, label='Todos los puntos')
ax.scatter(points_3d[optimal_subset_3d,0], 
           points_3d[optimal_subset_3d,1],
           points_3d[optimal_subset_3d,2],
           c='blue', edgecolor='black', s=60, 
           linewidths=1.5, marker='^', label='Subconjunto óptimo')

ax.set_title(f'Instancia 3D ({len(points_3d)} puntos)\nSubconjunto: {mu} puntos')
ax.set_xlabel('Coordenada X')
ax.set_ylabel('Coordenada Y')
ax.set_zlabel('Coordenada Z')
ax.view_init(elev=25, azim=-45)
ax.legend(loc='upper left')

plt.tight_layout()
plt.savefig('riesz_subset_comparison.png', dpi=300)
plt.show()