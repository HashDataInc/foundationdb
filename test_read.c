#include <stdio.h>

int main()
{
	int size, cnt;
	int i;
	char buf[100*1024];
	FILE *fp;

	fp = fopen("xb", "rb");
	while(1) {
		if(feof(fp))
			break;

		cnt = fread(&size, sizeof(int), 1, fp);
		if (cnt != 1)
			break;

		printf("len=%04d:", size);

		cnt = fread(buf, sizeof(unsigned char), size, fp);
		if (cnt != size)
			break;

		for (i = 0; i < size; i++)
		{
			unsigned char b = buf[i];
			if (b >= 32 && b < 127 && b != '\\') printf("%c", b);
			else if (b == '\\') printf("\\\\");
			else printf("\\x%02x", b);
		}
		printf("\n");
	}

}
