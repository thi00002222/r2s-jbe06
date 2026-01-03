#include <stdio.h>

// create function
void input(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("\n enter element %d:", i + 1);
        scanf("%d", &arr[i]);
    }
}

void output(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("%3d", arr[i]);
    }
}

void desOrder(int arr[], int size, int temp)
{
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            if (arr[i] >= arr[j])
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

void checkOdd(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        if (arr[i] % 2 != 0)
        {
            printf("\n All elements of the array are not odd");
            break;
        }
    }
}

void search(int arr[], int size, int n)
{
    for (int i = 0; i < size; i++)
    {
        if (i == n)
        {
            printf("\n the value is: %d", arr[i]);
        }
    }
}

int checkPrime(int n)
{
    if (n < 2)
        return 0;

    for (int i = 2; i * i <= n; i++)
    {
        if (n % i == 0)
            return 0;
    }
    return 1;
}

void printPrimeElements(int arr[], int size)
{
    printf("Prime numbers in the array: ");

    for (int i = 0; i < size; i++)
    {
        if (checkPrime(arr[i]))
        {
            printf("%d ", arr[i]);
        }
    }
    printf("\n");
}

int main()
{
    int quit = 0;
    const int MAX_SIZE = 100;
    int size, arr[MAX_SIZE];
    int choice;

    do
    {
        printf("\n*----------------------------------------------------------------*\n");
        printf("|1. Input the array                                              |\n");
        printf("|2. Output the array                                             |\n");
        printf("|3. Print out the array in descending order                      |\n");
        printf("|4. Check if all elements of the array are odd                   |\n");
        printf("|5. Search a value                                               |\n");
        printf("|6. Displays elements that are prime numbers in the array        |\n");
        printf("|7. Quit                                                         |");
        printf("\n*----------------------------------------------------------------*\n");

        printf("your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            // enter size for array
            printf("Enter size: ");
            scanf("%d", &size);
            printf("\n Array have %d elements.", size);
            input(arr, size);
            break;

        case 2:
            printf("Array you import: ");
            output(arr, size);
            break;
        case 3:
            int temp = 0;
            desOrder(arr, size, temp);
            printf("\n Array descending");
            for (int i = 0; i < size; i++)
            {
                printf("%3d", arr[i]);
            }
            break;

        case 4:
            checkOdd(arr, size);
            break;
        case 5:
            int n;
            printf("\n enter a value: ");
            scanf("%d", &n);
            search(arr, size, n);
            break;
        case 6:
            printPrimeElements(arr, size);
            break;
        case 7:
            getchar();
            printf("\n Are you sure?");
            getchar();
            printf("Exiting...\n");
            quit = 1;
            break;
        default:
            printf("please choice again");
            scanf("%d",&choice);
        }

    } while (quit == 0);
}
