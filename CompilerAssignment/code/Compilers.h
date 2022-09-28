/*
************************************************************
* COMPILERS COURSE - Algonquin College
* Code version: Fall, 2022
* Author: Svillen Ranev - Paulo Sousa
* Professors: Paulo Sousa
************************************************************
 _________________________________
|                                 |
| ........ VENOM LANGUAGE ......... |
|     __    __    __    __        |
|    /  \  /  \  /  \  /  \       |
| __/  __\/  __\/  __\/  __\__    |
| _/  /__/  /__/  /__/  /_____|   |
|  \_/ \   / \   / \   / \  \___  |
|       \_/   \_/   \_/   \___o_> |
|                                 |
| .. ALGONQUIN COLLEGE - 2022F .. |
|_________________________________|

*/

/*
************************************************************
* File name: compilers.h
* Compiler: MS Visual Studio 2022
* Course: CST 8152 – Compilers, Lab Section: [011, 012, 013]
* Assignment: A12, A22, A32.
* Date: Sep 01 2022
* Professor: Paulo Sousa
* Purpose: This file defines the functions called by main function.
* Function list: mainReader(), mainScanner(), mainParser().
*************************************************************/

#ifndef COMPILERS_H_
#define COMPILERS_H_

#define DEBUG 0

/*
 * ............................................................................
 * ADVICE 1:
 * Please check the "TODO" labels to develop your activity.
 *
 * ADVICE 2: This file must be updated according to each assignment
 * (see the progression: reader > scanner > parser).
 * ............................................................................
 */
 
/* Logical constants - adapt for your language */
#define VENOM_TRUE  1
#define VENOM_FALSE 0

/*
------------------------------------------------------------
Data types definitions
NOTE: Some types may not be directly used by your language,
		but they can be necessary for conversions.
------------------------------------------------------------
*/
/* TO_DO: Define your typedefs */
typedef char			VENOM_char;
typedef int				VENOM_intg;
typedef float			VENOM_real;
typedef void			VENOM_void;

typedef unsigned char	VENOM_boln;
typedef unsigned char	VENOM_byte;

typedef long			VENOM_long;
typedef double			VENOM_doub;

/*
------------------------------------------------------------
Programs:
1: Reader - invokes MainReader code
2: Scanner - invokes MainScanner code
3: Parser - invokes MainParser code
------------------------------------------------------------
*/
enum PROGRAMS {
	PGM_READER	= 'R',
	PGM_SCANNER = 'S',
	PGM_PARSER	= 'P'
};

/*
------------------------------------------------------------
Main functions signatures
(Code will be updated during next assignments)
------------------------------------------------------------
*/
VENOM_intg mainReader  (VENOM_intg argc, VENOM_char** argv);
/*
VENOM_intg mainScanner (VENOM_intg argc, VENOM_char** argv);
VENOM_intg mainParser  (VENOM_intg argc, VENOM_char** argv);
*/
VENOM_void printLogo();

#endif
