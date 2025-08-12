SRC = $(wildcard src/*.java)
OUT = out
MAIN = Main

build:
	mkdir -p $(OUT)
	javac -d $(OUT) $(SRC)

run: build
	java -Xms4g -Xmx12g -cp $(OUT) $(MAIN)

clean:
	rm -rf $(OUT)
