cmake_minimum_required(VERSION 4.3)
project(C C)

set(CMAKE_C_STANDARD 11)

add_subdirectory("${PROJECT_SOURCE_DIR}/number-print" "${PROJECT_SOURCE_DIR}/number-print/build")
add_subdirectory("${PROJECT_SOURCE_DIR}/stack" "${PROJECT_SOURCE_DIR}/stack/build")
