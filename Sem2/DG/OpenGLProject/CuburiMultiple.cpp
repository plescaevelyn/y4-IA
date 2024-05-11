#include "resource/SOIL2/SOIL2.h"
#include <iostream>
#define GLEW_STATIC
#include <GL/glew.h>


//#include <glfw/glfw3.h>
#include <glfw/include/GLFW/glfw3.h>
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include<glm/ext/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>
#include <glm/gtc/random.hpp>
#include "resource/c10/perspective/Shader.h"

#include <array>
#include <iostream>
#include <stdlib.h> 
#include <fstream>
#include <Windows.h>
#include <vector>

using namespace std;

GLfloat increaseX = 0;
GLfloat increaseY = 0;
GLfloat increaseZ = 0;
const GLuint WIDTH = 1000, HEIGHT = 1000;
GLfloat repetition = 0;
GLfloat j = 10.0;

// ex 2
void context()
{
	glfwInit();
	glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
	glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 1);
	glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_ANY_PROFILE);
	glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
	glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
}

glm::mat4 transform(GLchar axes)
{
	glm::mat4 transformMatrix = glm::mat4(1.0f);
	GLfloat step = -2;
	GLfloat angle = 0;
	glm::vec3 axesV;
	if (axes == 'z')
	{
		axesV = glm::vec3(0.0f, 0.0f, 1.0f);
	}
	angle = (GLfloat)glfwGetTime() * step;
	transformMatrix = glm::rotate(transformMatrix, angle, axesV);
	transformMatrix = glm::translate(transformMatrix, glm::vec3(0.75f, 0.75f, 0.0f));
	return transformMatrix;
}


// citire date din fisiere pt rotatii si translatii
std::vector<float> readData(const std::string& filename) {
	std::vector<float> data;

	std::ifstream file(filename);
	if (!file.is_open()) {
		std::cerr << "Can't open the specified file" << filename << std::endl;
		return data;
	}

	float value;

	while (file >> value) {
		data.push_back(value);
	}

	file.close();

	return data;
}


int main()
{
	// ex 4
	GLfloat vertexArray[] = {
		//back
	   0.75f, -0.75f, -0.75f, 0.0f, 0.0f,
		-0.75f, -0.75f, -0.75f, 1.0f, 0.0f,
		-0.75f, 0.75f, -0.75f, 1.0f, 1.0f,
	   0.75f, -0.75f, -0.75f, 0.0f, 0.0f,
	   0.75f, 0.75f, -0.75f, 0.0f, 1.0f,
		-0.75f, 0.75f, -0.75f, 1.0f, 1.0f,
		//front
	   -0.75f, -0.75f, 0.75f, 0.0f, 0.0f,
		0.75f, -0.75f, 0.75f, 1.0f, 0.0f,
		0.75f, 0.75f, 0.75f, 1.0f, 1.0f,
		0.75f, 0.75f, 0.75f, 1.0f, 1.0f,
		-0.75f, 0.75f, 0.75f, 0.0f, 1.0f,
		-0.75f, -0.75f, 0.75f, 0.0f, 0.0f,
		//right
	   0.75f, 0.75f, 0.75f, 0.0f, 1.0f,
	   0.75f, 0.75f, -0.75f, 1.0f, 1.0f,
	   0.75f, -0.75f, -0.75f, 1.0f, 0.0f,
	   0.75f, -0.75f, -0.75f, 1.0f, 0.0f,
	   0.75f, -0.75f, 0.75f, 0.0f, 0.0f,
	   0.75f, 0.75f, 0.75f, 0.0f, 1.0f,
	   //left
	   -0.75f, 0.75f, 0.75f, 1.0f, 1.0f,
	   -0.75f, -0.75f, +0.75f, 1.0f, 0.0f,
	   -0.75f, -0.75f, -0.75f, 0.0f, 0.0f,
	   -0.75f, -0.75f, -0.75f, 0.0f, 0.0f,
	   -0.75f, +0.75f, -0.75f, 0.0f, 1.0f,
	   -0.75f, 0.75f, 0.75f, 1.0f, 1.0f,
	   //up
	   -0.75f, 0.75f, -0.75f, 0.0f, 1.0f,
	   0.75f, 0.75f, -0.75f, 1.0f, 1.0f,
	   0.75f, 0.75f, 0.75f, 1.0f, 0.0f,
	   0.75f, 0.75f, 0.75f, 1.0f, 0.0f,
	   -0.75f, 0.75f, 0.75f, 0.0f, 0.0f,
	   -0.75f, 0.75f, -0.75f, 0.0f, 1.0f,
	   //down
	   -0.75f, -0.75f, -0.75f, 1.0f, 1.0f,
	   0.75f, -0.75f, -0.75f, 0.0f, 1.0f,
	   0.75f, -0.75f, 0.75f, 0.0f, 0.0f,
	   0.75f, -0.75f, 0.75f, 0.0f, 0.0f,
	   -0.75f, -0.75f, 0.75f, 1.0f, 0.0f,
	   -0.75f, -0.75f, -0.75f, 1.0f, 1.0f,
	};

	//-------------------------------------------------------------------------CITIRE DATE------------------------------------------------------------------------
	//Read displacement vectors for X axis
	std::vector<float> readDataX = readData("DisplacementX.txt");

	//Read displacement vectors for Y axis
	std::vector<float> readDataY = readData("DisplacementY.txt");

	//Read displacement vectors for Z axis
	std::vector<float> readDataZ = readData("DisplacementZ.txt");

	//Read gyroscope vectors for X axis
	std::vector<float> gyroX = readData("AllGyrX.txt");

	//Read gyroscope vectors for Y axis
	std::vector<float> gyroY = readData("AllGyrY.txt");

	//Read gyroscope vectors for Z axis
	std::vector<float> gyroZ = readData("AllGyrX.txt");

	//----------------------------------------------------------------------------INITIALIZARE FATETE(VERTEX)---------------------------------------



	//-------------------------------------------------------------------------------CREARE FEREASTRA APLICATIE------------------------------------------

	// ex 3
	GLuint VBO, VAO, EBO;
	int screenWidth, screenHeight;
	context();
	GLFWwindow* window = glfwCreateWindow(800, 800, "fereastra mea", nullptr, nullptr);
	glfwGetFramebufferSize(window, &screenWidth, &screenHeight);
	//std::cout << "Screen Width= " << screenWidth;
	if (nullptr == window)
	{
		std::cout << "Failed to create GLFW window" <<
			std::endl;
		glfwTerminate();
		return EXIT_FAILURE;
	}
	glfwMakeContextCurrent(window);
	glewExperimental = GL_TRUE;
	if (GLEW_OK != glewInit())
	{
		std::cout << "Failed to initialize GLEW" << std::endl;
		return EXIT_FAILURE;
	}
	glEnable(GL_DEPTH_TEST);
	glEnable(GL_BLEND);
	glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);




	//--------------------------------------------------------------ADAUGAREA REFERINTELOR LA SHADER SI MANIPULARE BUFFER-------------------------------- 
	//Shader userShader("resource/c11/perspective/vertex.sh", "resource/c11/perspective/fragment.sh");

	// ex 5 a
	Shader userShader("resource/c11/perspective/vertex.sh", "resource/c11/perspective/fragment.sh");
	glGenVertexArrays(1, &VAO);
	glGenBuffers(1, &VBO);
	glBindVertexArray(VAO);
	glBindBuffer(GL_ARRAY_BUFFER, VBO);
	glBufferData(GL_ARRAY_BUFFER, sizeof(vertexArray), vertexArray, GL_STATIC_DRAW);
	glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 5 * sizeof(GLfloat), (GLvoid*)0);
	glEnableVertexAttribArray(0);
	glVertexAttribPointer(1, 2, GL_FLOAT, GL_FALSE, 5 * sizeof(GLfloat), (GLvoid*)(3 * sizeof(GLfloat)));
	glEnableVertexAttribArray(1);
	glBindVertexArray(0);

	//-----------------------------------------------------------------------ADAUGAREA MODELELOR TEXTURILOR------------------------------------------------------------
	GLuint texture0, texture1;
	int width = 100, height = 100;

	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);// GL_LINEAR);
	GLuint texture[6];
	// ex 5 b 
	array<unsigned char*, 6> imageInfo;
	array<const char*, 6> filePath = {
	"resource/images/red_.jpg",//back
	"resource/images/green_.jpg",//front
	"resource/images/blue_.jpg", // right
	"resource/images/yellow_.jpg", //left
	"resource/images/pink_.jpg", //up
	"resource/images/grey.jpg" //down
	};


	//-----------------------------------------------------------------------APLICAREA TEXTURILOR PE CUBURI-----------------------------------------------------------
	// ex 5 c
	for (int i = 0; i < 6; i++)
	{
		glGenTextures(1, &texture[i]);
		glBindTexture(GL_TEXTURE_2D, texture[i]);
		imageInfo[i] = SOIL_load_image(filePath[i], &width, &height, 0, SOIL_LOAD_RGBA);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, imageInfo[i]);
		glGenerateMipmap(GL_TEXTURE_2D);
		SOIL_free_image_data(imageInfo[i]);
		glBindTexture(GL_TEXTURE_2D, 0);
	}


	//----------------------------------------------------------------------FUNCTIA MATRICII DE PROIECTIE SI GENERARE DE POZITI ALEATOARE CUBURI--------------------------------------

	// ex 6
	glm::mat4 projectionMatrix;
	projectionMatrix = glm::perspective(glm::radians(80.0f), (GLfloat)screenWidth / (GLfloat)screenHeight, 0.1f, 150.0f);
	//generating the position for all the cubes
	array<glm::vec3, 6> position;
	for (int k = 0; k < 6; k++)
	{
		position[k] = glm::sphericalRand(5.0f);
	}

	glActiveTexture(GL_TEXTURE0);


	//---------------------------------------------------------------RULAREA CODULUI DIN FEREASTRA CREATA----------------------------------------------------------

	// ex 7 a
	while (!glfwWindowShouldClose(window))
	{
		// ex 7 d
		glfwPollEvents();
		glClearColor(0.4f, 0.0f, 0.0f, 1.f);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		userShader.Use();

		// ex 7 e
		glm::mat4 modelMatrix = glm::mat4(1.0f), viewMatrix = glm::mat4(1.0f), viewMatrixRef = glm::mat4(1.0f);
		modelMatrix = glm::rotate(modelMatrix, 0.f, glm::vec3(1.f, 0.f, 1.f));
		int distance = 12;
		glm::vec3 center = glm::vec3(0., 0., 0.);
		viewMatrix = glm::lookAt(glm::vec3(sin(3.14) * distance, 0, cos(3.14) * distance), center, glm::vec3(0, 0, 1));

		GLint transformLocation;
		transformLocation = glGetUniformLocation(userShader.Program, "modelMatrix");

		glUniformMatrix4fv(transformLocation, 1, GL_FALSE, glm::value_ptr(modelMatrix));
		transformLocation = glGetUniformLocation(userShader.Program, "viewMatrix");

		glUniformMatrix4fv(transformLocation, 1, GL_FALSE, glm::value_ptr(viewMatrix));
		transformLocation = glGetUniformLocation(userShader.Program, "projectionMatrix");
		glUniformMatrix4fv(transformLocation, 1, GL_FALSE, glm::value_ptr(projectionMatrix));
		glBindVertexArray(VAO);



		//--------------------MISCAREA CUBURILOR------------------------
		for (int p = 0; p < 6; p++)//6 cuburi
		{
			if (p == 0) {
				viewMatrixRef = glm::translate(viewMatrix, glm::vec3(0.f, 0.f, 0.f));
			} //----- EXEMPLU PASTRARE PRIMUL CUB STATIONAR
			else
			{

				//EXEMPLU TRANSLATIE PRINTR-UN VECTOR POSITION
				position[p].x = readDataX[1] / 10;
				position[p].y = readDataY[1] / 10;
				position[p].z = readDataZ[1] / 10;

				viewMatrixRef = glm::translate(viewMatrix, position[p]);

				transformLocation = glGetUniformLocation(userShader.Program, "viewMatrix"); //----FOLOSITE PENTRU ACTUALIZARE VIEWMATRIX
				glUniformMatrix4fv(transformLocation, 1, GL_FALSE, glm::value_ptr(viewMatrixRef));

				// aplica 3 rotatii diferite pe model matrix de aici 
				modelMatrix = glm::rotate(modelMatrix, gyroX[1] / 10, glm::vec3(1.f, 0.f, 0.f)); // h

				transformLocation = glGetUniformLocation(userShader.Program, "modelMatrix"); //----FOLOSITE PENTRU ACTUALIZARE MODELMATRIX
				glUniformMatrix4fv(transformLocation, 1, GL_FALSE, glm::value_ptr(modelMatrix));

			}
			//REDESENARE

			// ex 7 f
			for (int i = 0; i < 6; i++) {
				glBindTexture(GL_TEXTURE_2D, texture[i]);
				glUniform1i(glGetUniformLocation(userShader.Program, "userTextureOut"), 0);
				glDrawArrays(GL_TRIANGLES, i * 6, 6);
			}
			viewMatrixRef = viewMatrix;
		}

		//----------GOLIRE COMPLETA BUFFER--------------

		// ex 7 b
		glBindVertexArray(0);
		glBindTexture(GL_TEXTURE_2D, 0);
		glfwSwapBuffers(window);
	}
	//----------------------------RESETARE VIEWPORT SI OPRIRE EXECUTIE---------------


	// ex 7 c
	glViewport(0, 0, screenWidth, screenHeight);
	glDeleteVertexArrays(1, &VAO);
	glDeleteBuffers(1, &VBO);
	glfwTerminate();
	return EXIT_SUCCESS;

}